import React, { useState } from "react";
import axios from "axios";

const newVideoUrl = "http://localhost:8181/new-video"

function saveNewVideo(name, url){
    axios.post(newVideoUrl, {name, url}, {headers: {'Content-Type': 'application/json'}}
    )}

export default function NewVideo() {

    const [name, setName] = useState("");
    const [url, setUrl] = useState("");

    const onChangeName = (e) => {
        const name = e.target.value;
        setName(name);
    };

    const onChangeUrl = (e) => {
        const url = e.target.value;
        setUrl(url);
    };

    return (
        <div>
            <form action="/">
                <label htmlFor="name">Name:</label><br/>
                <input 
                type="text"
                name="name"
                value={name}
                onChange={onChangeName}
                /><br/>
                <label htmlFor="url">URL:</label><br/>
                <input 
                type="text"
                name="url"
                value={url}
                onChange={onChangeUrl}
                /><br/>
                <a href="/"><input type="button" value="Add" onClick={() => {saveNewVideo(name, url)}}/></a>
            </form>
        </div>
        
    )
}
