package lemongrab.kryo;

import com.twitter.chill.KryoPool;
import com.twitter.chill.SerDeState;
import java.io.IOException;
import java.io.InputStream;

public class ObjectInput {
    protected KryoPool pool;
    protected SerDeState serde;
    
    public ObjectInput(KryoPool pool, InputStream inputStream) {
        this.pool = pool;
        serde = pool.borrow();
        serde.setInput(new byte[4096]);
        serde.setInput(inputStream);
    }

    public Object readObject()
        throws ClassNotFoundException, IOException {
        if (serde == null)
            throw new IOException("Trying to readObject from closed ObjectInput");
        return serde.readClassAndObject();
    }

    public void close()
        throws IOException {
        if (serde == null)
            throw new IOException("Trying to close an already closed ObjectInput");
        pool.release(serde);
        serde = null;
    }
}

