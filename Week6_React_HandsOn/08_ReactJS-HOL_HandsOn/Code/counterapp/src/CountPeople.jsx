import React, { useState } from 'react';
import './CountPeople.css'; 

const CountPeople = () => {
  const [entrycount, setentrycount] = useState(0);
  const [exitcount, setexitcount] = useState(0);

  const updateEntry = () => {
    setentrycount(entrycount + 1);
  };

  const updateExit = () => {
    setexitcount(exitcount + 1);
  };

  return (
    <div className="container">
      <div className="card">
        <button onClick={updateEntry}>Login</button>
        <p>{entrycount} People Entered!!!</p>
      </div>

      <div className="card">
        <button onClick={updateExit}>Exit</button>
        <p>{exitcount} People Left!!!</p>
      </div>
    </div>
  );
};

export default CountPeople;
