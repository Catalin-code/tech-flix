import React, { useState, useEffect } from "react";
import axios from "axios";
import YoutubeEmbed from "./YoutubeEmbed";


export default function Home() {
    const baseUrl = "http://localhost:8181/videos";
    const [videosData, setVideosData] = useState([]);

    const getData = async () => {
        try {
          const { data } = await axios.get(baseUrl);
          setVideosData(data);
          console.log(data);
        } catch (err) {
          console.log(err.message);
        }
    };
    
    useEffect(() => {
        getData();
    }, []);

    return (
        <div>
            <a href="/new-video"><button>New video</button></a>
            {videosData.map((video) => (
                <div>
                    <YoutubeEmbed embedId={video.url.split("v=")[1]} />
                    <a href={"/video/" + video.id}><button>Video details</button></a>
                </div>
            ))}
        </div>
    )
}
