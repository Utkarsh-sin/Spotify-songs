import java.util.*;

public class Main {
    public static List<Album> albums =new ArrayList<>();
    public static void main(String[] args) {

        Album album1=new Album("Arijit's Song","Arijit Singh");
        album1.addSongtoAlbum("Kesariya",5.02);
        album1.addSongtoAlbum("Jeena Jeena",4.48);
        album1.addSongtoAlbum("Tum Hi Ho",4.30);

        Album album2=new Album("Shaan ke Suhane", "Shaan");
        album2.addSongtoAlbum("Behti Hawa Sa Tha Wo",5.30);
        album2.addSongtoAlbum("Bum Bum Bole",4.38);
        album2.addSongtoAlbum("Aal Izz Well",3.50);

        albums.add(album1);
        albums.add(album2);

        System.out.println(album1.findSong("Kesariya"));

        LinkedList<Song> myPlaylist = new LinkedList<>();
        album1.addToPlaylistFronAlbum("Jeena Jeena",myPlaylist);
        album1.addToPlaylistFromAlbum(3,myPlaylist);
        album2.addToPlaylistFromAlbum(1,myPlaylist);
        album2.addToPlaylistFronAlbum("Aal Izz Well",myPlaylist);

        play(myPlaylist);
    }

    public static void play(LinkedList<Song> playList){
        Scanner sc=new Scanner(System.in);
        ListIterator<Song> itr = playList.listIterator();

        boolean isForward = false;

        if(playList.size()>0){
            System.out.println("Current playing");
            System.out.println(itr.next());
            isForward = true;
        }
        else{
            System.out.println("Playlist is empty");
            return;
        }

        System.out.println("Enter your choice");
        printMenu();
        boolean quit = false;
        while(!quit){
            int choice = sc.nextInt();
            switch(choice){
                case 1:
                    if(isForward ==  false){
                        itr.next();
                        isForward = true;
                    }
                    if(itr.hasNext()){
                        System.out.println(itr.next());
                    }
                    else{
                        System.out.println("You have reached the end of Playlist");
                        //isForward = false;
                    }
                    break;
                case 2:
                    if(isForward == true){
                        itr.previous();
                        isForward = false;
                    }
                    if(itr.hasPrevious()){
                        System.out.println(itr.previous());
                    }
                    else{
                        System.out.println("You are at the start of your Playlist");
                       // isForward = true;
                    }
                    break;
                case 3:
                    if(isForward==true && itr.hasPrevious()){ // not required to check previous as it will always be true;
                        System.out.println(itr.previous());
                        isForward = false;
                    }
                    else{
                        if(itr.hasNext()){ // not required to check
                            System.out.println(itr.next());
                            isForward = true;
                        }
                    }
                    break;
                case 4:
                    if(playList.size()>0) {
//                        if (isForward == true) {
//                            if (itr.hasPrevious()) {// not required will always be true
//                                playList.remove(itr.previous());
//                                System.out.println("Deleted current song");
//                                itr.remove();
//                            }
//                        }
//                        else {
//                            if(itr.hasNext()) { //not required
//                                playList.remove(itr.next());
//                                System.out.println("Deleted current song");
//                                itr.remove();
//                            }
//                        }
                        System.out.println("Deleted current song");
                        itr.remove();
                    }
                    else{
                        System.out.println("Your playlist is empty");
                    }
                    break;
                case 5:
                    for(Song s: playList){
                        System.out.println(s);
                    }
                    break;
                case 6:
                    printMenu();
                    break;
                case 7:
                    quit = true;
                    break;
                default:
                    System.out.println("Please enter valid choice");
                    break;
            }
        }

    }
    public static void printMenu(){
        System.out.println("1 - Play next song");
        System.out.println("2 - Play previous song");
        System.out.println("3 - Repeat the current song");
        System.out.println("4 - Delete the current song");
        System.out.println("5 - Print all the songs in playlist");
        System.out.println("6 - Show menu again");
        System.out.println("7 - Exit");

    }

}