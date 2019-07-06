package h_proxy.static_;

/**
 * Created with IDEA
 * author:wenka wkwenka@gmail.com
 * Date:2019/01/21  下午 01:52
 * Description:
 */
public class RealFile implements File {

    private String fileName;

    public RealFile(String fileName) {
        this.fileName = fileName;
        this.loadFile(fileName);
    }

    @Override
    public void display() {
        System.out.println("display.... [fileName=" + fileName + "]");
    }

    public void loadFile(String fileName) {
        System.out.println("loading.... [fileName=" + fileName + "]");
    }
}
