import React, {useState, useEffect} from 'react';
import { useParams } from "react-router-dom";

import axios from 'axios';

export default function VideoDetails() {
    let { id } = useParams();
    const videoBaseUrl = "http://localhost:8181/video/";
    const videoRecoBaseUrl = "http://localhost:8181/recommendation/";
    const [videoData, setVideoData] = useState([]);
    const [videoRecoData, setVideoRecoData] = useState([]);

    const getVideoData = async (videoId) => {
        try {
          const { data } = await axios.get(videoBaseUrl + videoId);
          setVideoData(data);
          console.log(data);
        } catch (err) {
          console.log(err.message);
        }
    };

    const getVideoRecoData = async (videoId) => {
        try {
          const { data } = await axios.get(videoRecoBaseUrl + videoId);
          setVideoRecoData(data);
          console.log(data);
        } catch (err) {
          console.log(err.message);
        }
    };

    useEffect(() => {
        getVideoData(id);
        getVideoRecoData(id);
    }, [id]);

    return (
        <div>
            {videoData.map((video) => (
                <div>
                    <h1>{video.name}</h1>
                    <a href={video.url}><h4>{video.url}</h4></a>
                    {videoRecoData.map((videoReco) => (
                        <div>
                            <a href={videoReco.recommendation}><h5>{videoReco.recommendation}</h5></a>
                        </div>
                    ))}
                </div>
            ))}
        </div>
    )
}
