package h_proxy;

/**
 * Created with IDEA
 * author:wenka wkwenka@gmail.com
 * Date:2019/01/21  下午 01:54
 * Description:
 */
public class ProxyFile implements File {

    private RealFile realFile;
    private String fileName;

    public ProxyFile(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if (this.realFile == null) {
            realFile = new RealFile(fileName);
        }
        realFile.display();
    }
}
