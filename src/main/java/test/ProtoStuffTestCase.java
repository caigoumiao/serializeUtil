package test;

import org.junit.Test;
import util.KryoUtil;
import util.ProtoStuffUtil;

public class ProtoStuffTestCase
{
    static User u=new User("miaoqiao", 21, true, "nihao","nihao","nihao","nihao","nihao","nihao","nihao","nihao","nihao");

    @Test
    public void testProtoStuff(){
        long startTime= System.currentTimeMillis();
        byte[] tmp = ProtoStuffUtil.serialize(u);
        long endTime=System.currentTimeMillis();
        System.out.println("序列化耗时："+ (endTime-startTime)+"ms");
        System.out.println("码流大小为：" + tmp.length+" byte");
        startTime= System.currentTimeMillis();
        User u1= (User) ProtoStuffUtil.deserialize(tmp, User.class);
        endTime=System.currentTimeMillis();
        System.out.println("反序列化耗时："+ (endTime-startTime)+"ms");
    }
}
