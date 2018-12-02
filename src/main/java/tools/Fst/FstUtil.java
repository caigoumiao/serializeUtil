package tools.Fst;

import org.nustaq.serialization.FSTConfiguration;

public class FstUtil
{
    private static FSTConfiguration fstConfiguration=FSTConfiguration.createDefaultConfiguration();

    public static void setConfType(ConfType confType){
        switch (confType){
            case UNSAFE:
                fstConfiguration=FSTConfiguration.createUnsafeBinaryConfiguration();break;
            case MINBIN:
                fstConfiguration=FSTConfiguration.createMinBinConfiguration();break;
            case JSONNOREF:
                fstConfiguration=FSTConfiguration.createJsonNoRefConfiguration();break;
            default:
                fstConfiguration=FSTConfiguration.createDefaultConfiguration();break;
        }
    }

    public static byte[] serialize(Object obj){
        return fstConfiguration.asByteArray(obj);
    }

    public static Object deserialize(byte[] bytes){
        return fstConfiguration.asObject(bytes);
    }

    /**
     * 默认采用DefalutConfiguration , 这种大多数情况下最快最稳定
     * UNSAFE : 在某些场景（许多本地数组）中，它可以快几倍。
     * MINBIN : MinBin serialization ('binary JSon') is much slower than the other
     * JSONNOREF : a configuration encoding to JSon without support for reference sharing (=> NO cyclic object graphs)
     */
    public static enum ConfType{
        DEFAULT, UNSAFE, MINBIN, JSONNOREF;
    }
}
