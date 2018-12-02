package tools.Hessian;

import com.caucho.hessian.io.HessianInput;
import com.caucho.hessian.io.HessianOutput;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class HessianUtil
{
    public static byte[] serialize(Object obj) throws IOException
    {
        ByteArrayOutputStream byteArray=new ByteArrayOutputStream(1024);
        HessianOutput output = null;
        try
        {
            output= new HessianOutput(byteArray);
            output.writeObject(obj);
            byteArray.flush();
            return byteArray.toByteArray();
        } finally
        {
            if (output != null)
            {
                output.close();
            }
        }
    }

    public static Object deserialize(byte[] bytes, Class cls){
        HessianInput input=new HessianInput(new ByteArrayInputStream(bytes));
        try
        {
            return input.readObject(cls);
        } catch (IOException e)
        {
            return null;
        }
    }
}
