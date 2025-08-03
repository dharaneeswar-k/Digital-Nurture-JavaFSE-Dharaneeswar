
import { BrowserRouter, Routes, Route, Link } from 'react-router-dom';
import Home from './Home';
import TrainerList from './TrainerList';
import TrainerDetail from './TrainerDetail';
import TrainerMock from './TrainerMock';

function App() {
  return (
    <BrowserRouter>
      <div style={{ padding: '10px' }}>
        <h1>My Academy Trainers App</h1>

        <nav style={{ marginBottom: '10px' }}>
          <Link to="/" style={{ marginRight: '10px' }}>Home</Link> |
          <Link to="/trainers" style={{ marginLeft: '10px' }}>Show Trainers</Link>
        </nav>

        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/trainers" element={<TrainerList trainers={TrainerMock} />} />
          <Route path="/trainers/:id" element={<TrainerDetail />} />
        </Routes>
      </div>
    </BrowserRouter>
  );
}

export default App;
