package a_adapter;

import a_adapter.entity.Mp4Player;
import a_adapter.entity.VlcPlayer;
import a_adapter.in.AdvancedMediaPlayer;
import a_adapter.in.MediaPlayer;

/**
 * Created with IDEA
 * author:wenka wkwenka@gmail.com
 * Date:2019/01/10  下午 02:05
 * Description:
 */
public class MediaAdapter implements MediaPlayer {

    private AdvancedMediaPlayer advancedMediaPlayer;

    public MediaAdapter(String type) {
        if (type.equalsIgnoreCase("mp4")) {
            advancedMediaPlayer = new Mp4Player();
        } else if (type.equalsIgnoreCase("vlc")) {
            advancedMediaPlayer = new VlcPlayer();
        }
    }

    @Override
    public void play(String type, String name) {
        if (type.equalsIgnoreCase("mp4")) {
            advancedMediaPlayer.playMp4(name);
        } else if (type.equalsIgnoreCase("vlc")) {
            advancedMediaPlayer.playVlc(name);
        }
    }
}
