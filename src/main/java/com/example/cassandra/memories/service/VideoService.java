package com.example.cassandra.memories.service;

import com.example.cassandra.memories.KeysHelper.LatestVideosKey;
import com.example.cassandra.memories.KeysHelper.VideosByUserKey;
import com.example.cassandra.memories.model.LatestVideos;
import com.example.cassandra.memories.model.Videos;
import com.example.cassandra.memories.model.VideosByUser;
import com.example.cassandra.memories.repository.LatestVideosRepository;
import com.example.cassandra.memories.repository.VideosByUserRepository;
import com.example.cassandra.memories.repository.VideosRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.UUID;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class VideoService {

    @Autowired
    VideosRepository videosRepository;

    @Autowired
    VideosByUserRepository videosByUserRepository;

    @Autowired
    LatestVideosRepository latestVideosRepository;

    public Videos addVideo(Videos video)
    {
        UUID video_id = UUID.randomUUID();
        Timestamp added_date = new Timestamp(System.currentTimeMillis());

        video.setVideo_id(video_id);
        video.setDate_added(added_date);
        videosRepository.save(video);

        //Forming data object and saving it for videos by user table
        VideosByUserKey videosByUserKey = new VideosByUserKey();
        VideosByUser videosByUser = new VideosByUser();

        videosByUserKey.setUserid(video.getUser_id());
        videosByUserKey.setAdded_date(added_date);
        videosByUserKey.setVideo_id(video_id);

        videosByUser.setName(video.getName());
        videosByUser.setVideosByUserKey(videosByUserKey);
        videosByUserRepository.save(videosByUser);

        //Forming data object and saving it for videos by latest videos table
        LatestVideos latestVideos = new LatestVideos();
        LatestVideosKey latestVideosKey = new LatestVideosKey();

        latestVideosKey.setVideo_id(video_id);
        latestVideosKey.setDate_added(added_date);
        latestVideosKey.setYyyymmdd(new SimpleDateFormat("yyyyMMdd").format(added_date));

        latestVideos.setLatestVideosKey(latestVideosKey);
        latestVideos.setName(video.getName());
        latestVideos.setUser_id(video.getUser_id());
        latestVideosRepository.save(latestVideos);

        return video;
    }

    public Videos updatevideo(Videos video){

        // Updating videos table
        videosRepository.save(video);

        //Forming data object and updating it for videos by user table
        VideosByUserKey videosByUserKey = new VideosByUserKey();
        VideosByUser videosByUser = new VideosByUser();

        videosByUserKey.setUserid(video.getUser_id());
        videosByUserKey.setAdded_date(video.getDate_added());
        videosByUserKey.setVideo_id(video.getVideo_id());

        videosByUser.setName(video.getName());
        videosByUser.setVideosByUserKey(videosByUserKey);
        videosByUserRepository.save(videosByUser);

        //Forming data object and updating it for videos by latest videos table
        LatestVideos latestVideos = new LatestVideos();
        LatestVideosKey latestVideosKey = new LatestVideosKey();

        latestVideosKey.setVideo_id(video.getVideo_id());
        latestVideosKey.setDate_added(video.getDate_added());
        latestVideosKey.setYyyymmdd(new SimpleDateFormat("yyyyMMdd").format(video.getDate_added()));

        latestVideos.setLatestVideosKey(latestVideosKey);
        latestVideos.setName(video.getName());
        latestVideos.setUser_id(video.getUser_id());
        latestVideosRepository.save(latestVideos);

        return video;
    }

    public boolean deleteVideo(Videos video)
    {
        // deletion of video in videos table
        videosRepository.deleteById(video.getVideo_id());

        // deletion of video in videos by user table
        VideosByUserKey videosByUserKey = new VideosByUserKey();
        videosByUserKey.setVideo_id(video.getVideo_id());
        videosByUserKey.setUserid(video.getUser_id());
        videosByUserKey.setAdded_date(video.getDate_added());
        videosByUserRepository.deleteById(videosByUserKey);

        // deletion of video in latest videos table
        LatestVideosKey latestVideosKey = new LatestVideosKey();
        latestVideosKey.setYyyymmdd(new SimpleDateFormat("yyyyMMdd").format(video.getDate_added()));
        latestVideosKey.setDate_added(video.getDate_added());
        latestVideosKey.setVideo_id(video.getVideo_id());
        latestVideosRepository.deleteById(latestVideosKey);

        return true;
    }


}
