package assignment12;

interface Playable{
	void play();
	void pause();
	void stop();
}

class MP3Player implements Playable{
	public void play() {
		System.out.println("MP3 Player: Playing Music.");
	}
	public void pause() {
		System.out.println("MP3 Player: Music paused.");
	}
	public void stop() {
		System.out.println("MP3 Player: Music stopped.");
	}
}

class CDPlayer implements Playable{
	public void play() {
		System.out.println("CDPlayer: Playing CD.");
	}
	public void pause() {
        System.out.println("CD Player: CD paused.");
    }
    public void stop() {
        System.out.println("CD Player: CD stopped.");
    }
}

class StreamingPlayer implements Playable {

    public void play() {
        System.out.println("Streaming Player: Streaming music.");
    }

    public void pause() {
        System.out.println("Streaming Player: Stream paused.");
    }

    public void stop() {
        System.out.println("Streaming Player: Stream stopped.");
    }
}

public class MusicPlayer {

	public static void main(String[] args) {
		Playable mp3=new MP3Player();
		Playable cd=new CDPlayer();
		Playable stream=new StreamingPlayer();
		
		System.out.println("** MP3 Player Controls **");
        mp3.play();
        mp3.pause();
        mp3.stop();

        System.out.println("\n** CD Player Controls **");
        cd.play();
        cd.pause();
        cd.stop();

        System.out.println("\n** Streaming Player Controls **");
        stream.play();
        stream.pause();
        stream.stop();
	}

}
