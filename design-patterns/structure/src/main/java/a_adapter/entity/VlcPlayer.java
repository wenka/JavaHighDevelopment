package a_adapter.entity;

import a_adapter.in.AdvancedMediaPlayer;

/**
 * Created with IDEA
 * author:wenka wkwenka@gmail.com
 * Date:2019/01/10  下午 02:02
 * Description:
 */
public class VlcPlayer implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {
        System.out.println("play vlc: name=" + fileName);
    }

    @Override
    public void playMp4(String fileName) {

    }
}
