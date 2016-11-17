package lemongrab;

import lemongrab.kryo.ClojureKryoInstantiator;
import lemongrab.kryo.ObjectInput;
import com.twitter.chill.KryoPool;
import com.twitter.chill.SerDeState;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Utils {

  static KryoPool _kpool = new ClojureKryoInstantiator().defaultPool();

  public static byte[] serialize(Object obj) throws IOException {
    return _kpool.toBytesWithClass(obj);
  }

  public static void serialize(OutputStream stream, Object obj) throws IOException {
    SerDeState serde = _kpool.borrow();
    try {
      serde.writeClassAndObject(obj);
      serde.writeOutputTo(stream);
    }
    finally {
      _kpool.release(serde);
    }
  }

  public static Object deserialize(byte[] serialized) throws IOException {
    return _kpool.fromBytes(serialized);
  }

  public static ObjectInput openStream(InputStream inputStream) throws IOException {
    return new ObjectInput(_kpool, inputStream);
  }
}
