public class Song {
    private String artist;
    private String title;
    public String collectionName;
    private int duration;

    public Song (String artistName, String songTitle, String songCollection, int songDuration) {
        this.artist = artistName;
        this.title = songTitle;
        this.collectionName = songCollection;
        this.duration = songDuration;
    }
    public void setTitle(String songTitle) {
        title = songTitle;
    }
    public String getTitle() {
        return title;
    }
    public void setArtist(String artistName) {
        artist = artistName;
    }
    public String getArtist() {
        return artist;
    }
    public void setCollectionName(String songCollection) {
        collectionName = songCollection;
    }
    public String getCollectionName() {
        return collectionName;
    }
    public void setDuration(int songDuration) {
        duration = songDuration;
    }
    public int getDuration() {
        return duration;
    }
    public static void main(String[] args) {
        Song sed = new Song("The Ramones", "I wanna be Sedated","Randy's Collection", 148);
        Song one = new Song ("Daft Punk", "One More Time", "Randy's Collection", 322);

        sed.collectionName = "Randy's Collection";
        System.out.println("Collection: " + one.collectionName);
        printSong(sed);
        printSong(one);
    }
    public static void printSong(Song song) {
        int min = song.getDuration() / 60;
        int sec = song.getDuration() % 60;
        System.out.printf("%s (%s) - %d:%d\n",
                song.getTitle(), song.getArtist(), min, sec);
    }
}
