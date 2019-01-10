package a_adapter;

/**
 * Created with IDEA
 * author:wenka wkwenka@gmail.com
 * Date:2019/01/10  下午 02:11
 * Description:
 */
public class AdapterDemo {

    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();
        audioPlayer.play("mp4", "aaa");
        audioPlayer.play("mp3", "bbb");
        audioPlayer.play("vlc", "ccc");
    }
}
