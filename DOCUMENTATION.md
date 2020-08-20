# MEMORIES
This is an application where people can share upload the videos of all their memories.

# DATA MODEL
As the Cassandra data model should be designed based on Application usage queries and data model build on those.

I came up with 5 tables and the chebotko diagram is also added in the folder. 

Tables : users, videos, latest_videos, videos_by_user, comments_by_video

1. Users - contains user details (PK: userid)
2. videos - Complete details about video (PK: video_id).
3. latest_videos - this contains few details about a video and sorted according to 
   date added (PK:yyyymmdd), (CK: date_added(desc),video_id)
4. videos_by_user - This table is partitioned based on user and sorted according to
   date added (PK: user_id), (CL: added_date(desc), video_id)
5. comments_by_video - This table is partitioned based on Video and sorted according 
   to comment date date (PK: video_id), (CK: comment_id(desc))
