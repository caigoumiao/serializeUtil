package util;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.pool.KryoPool;
import com.sun.org.apache.xml.internal.serializer.Serializer;
import test.User;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class KryoUtil
{
    private static final KryoPool kryoPool;

    static {
        kryoPool=KryoPoolFactory.getKryoPoolInstance();
    }

    public static byte[] serialize(Object obj){
        Kryo kryo=kryoPool.borrow();
        try (Output output = new Output(4096))
        {
            kryo.writeClassAndObject(output , obj);
            kryoPool.release(kryo);
            return output.toBytes();
        }
    }

    public static Object deserialize(byte[] bytes){
        Kryo kryo=kryoPool.borrow();
        return kryo.readClassAndObject(new Input(bytes));
    }
}
