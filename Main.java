import java.util.ArrayList;

// Subject interface
interface Channel {
    void subscribe(Subscriber subscriber);
    void unsubscribe(Subscriber subscriber);
    void notifySubscribers();
    String getChannelName();
}

// ConcreteSubject class
class YouTubeChannel implements Channel {
    private String channelName;
    private ArrayList<Subscriber> subscribers = new ArrayList<>();

    public YouTubeChannel(String channelName) {
        this.channelName = channelName;
    }

    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
        System.out.println(subscriber.getName() + " subscribed to " + channelName);
    }

    public void unsubscribe(Subscriber subscriber) {
        subscribers.remove(subscriber);
        System.out.println(subscriber.getName() + " unsubscribed from " + channelName);
    }

    public void notifySubscribers() {
        System.out.println("Notifying subscribers of new video on " + channelName);
        for (Subscriber subscriber : subscribers) {
            subscriber.update(channelName);
        }
    }

    public String getChannelName() {
        return channelName;
    }

    // Simulate uploading a new video
    public void uploadVideo() {
        notifySubscribers();
    }
}

// Observer interface
interface Subscriber {
    String getName();
    void update(String channelName);
}

// ConcreteObserver class
class YouTubeSubscriber implements Subscriber {
    private String name;

    public YouTubeSubscriber(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void update(String channelName) {
        System.out.println(name + ": New video uploaded on " + channelName);
    }
}

public class Main {
    public static void main(String[] args) {
        YouTubeChannel channel = new YouTubeChannel("Programming Tutorials");

        Subscriber subscriber1 = new YouTubeSubscriber("Alice");
        Subscriber subscriber2 = new YouTubeSubscriber("Bob");

        channel.subscribe(subscriber1);
        channel.subscribe(subscriber2);

        channel.uploadVideo();

        channel.unsubscribe(subscriber1);

        channel.uploadVideo();
    }
}
