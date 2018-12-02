package tools.Kryo;

import org.junit.Test;
import KryoPoolFactory;
import KryoUtil;
import testModel.User;

public class KryoTestCase
{
    static User u=new User("miaoqiao", 21, true, "nihao","nihao","nihao","nihao","nihao","nihao","nihao","nihao","nihao");

    @Test
    public void testKryo(){
        long startTime= System.currentTimeMillis();
        byte[] tmp = KryoUtil.serialize(u);
        long endTime=System.currentTimeMillis();
        System.out.println("序列化耗时："+ (endTime-startTime)+"ms");
        System.out.println("码流大小为：" + tmp.length+" byte");
        startTime= System.currentTimeMillis();
        User u1= (User) KryoUtil.deserialize(tmp);
        endTime=System.currentTimeMillis();
        System.out.println("反序列化耗时："+ (endTime-startTime)+"ms");
    }
}
