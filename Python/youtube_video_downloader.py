from pytube import YouTube
from pytube import Playlist

def download_video(object, SAVE_PATH):
    object.filter(file_extension='mp4').order_by('resolution').desc().first().download(SAVE_PATH)

def download_audio(object, SAVE_PATH):
    object.filter(mime_type='audio/mp4').order_by('abr').desc().first().download(SAVE_PATH)


def download_single(link, SAVE_PATH, file_extension):
    if file_extension == "mp4":
        yt = YouTube(link)
        print("Downloading:\t" + yt.title)
        download_video(yt.streams, SAVE_PATH)
    else:
        yt = YouTube(link)
        print("Downloading:\t" + yt.title)
        download_audio(yt.streams, SAVE_PATH)
    

def download_playlist(link, SAVE_PATH, file_extension):
    pl = Playlist(link)
    for video in pl.videos:
        print("Downloading:\t" + video.title)
        if file_extension == "mp4":
            download_video(video.streams, SAVE_PATH)
        else:
            download_audio(video.streams, SAVE_PATH)

def main():
    SAVE_PATH = "D:/YT Download"
    SAVE_PATH_MOBILE = "/storage/emulated/0/Download/YT_Download"
    # SAVE_PATH = SAVE_PATH_MOBILE          # For mobile users only (Android)
    file_extension = "mp4"

    print("Enter the link: ")
    link = input()
    singleOrPlaylist = link.split("/")[-1].split("?")[0]

    print("1\tVideo\n2\tAudio")
    choice = int(input("Enter your choice: "))
    if choice == 1:
        SAVE_PATH = "D:\YT Download\Video"
        file_extension = "mp4"
    else:
        SAVE_PATH = "D:\YT Download\Audio"
        file_extension = "mp3"

    if singleOrPlaylist == "watch":
        download_single(link, SAVE_PATH, file_extension)
    elif singleOrPlaylist == "playlist":
        download_playlist(link, SAVE_PATH, file_extension)

if __name__ == "__main__":
    main()
