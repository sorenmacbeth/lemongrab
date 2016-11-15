package lemongrab;

import lemongrab.kryo.ClojureKryoInstantiator;
import com.twitter.chill.KryoPool;
import java.io.IOException;

public class Utils {

  static KryoPool _kpool = new ClojureKryoInstantiator().defaultPool();

  public static byte[] serialize(Object obj) throws IOException {
    return _kpool.toBytesWithClass(obj);
  }

  public static Object deserialize(byte[] serialized) throws IOException {
    return _kpool.fromBytes(serialized);
  }
}
