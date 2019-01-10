package a_adapter;

import a_adapter.in.MediaPlayer;

/**
 * Created with IDEA
 * author:wenka wkwenka@gmail.com
 * Date:2019/01/10  下午 02:09
 * Description:
 */
public class AudioPlayer implements MediaPlayer {
    @Override
    public void play(String type, String name) {
        if (type.equalsIgnoreCase("mp4") || type.equalsIgnoreCase("vlc")) {
            MediaAdapter mediaAdapter = new MediaAdapter(type);
            mediaAdapter.play(type, name);
        } else {
            System.out.println("old>>" + type + ": name=" + name);
        }
    }
}
