import React from 'react';
import {
  BrowserRouter as Router,
  Switch,
  Route,
} from "react-router-dom";
import NewVideo from './components/NewVideo';
import Home from './components/Home';
import VideoDetails from './components/VideoDetails';


function App() {
  return (
    <Router>
      <Switch>
        <Route exact path="/new-video" component={NewVideo} />
        <Route path="/video/:videoId" component={VideoDetails} />
        <Route path="/" component={Home} />
      </Switch>
    </Router>
  );
}

export default App;
