import { Link } from 'react-router-dom';

export default function TrainerList({ trainers }) {
  return (
    <div style={{ padding: '10px' }}>
      <h3>Trainers List</h3>
      <ul>
        {trainers.map((trainer) => (
          <li key={trainer.trainerid}>
            <Link to={`/trainers/${trainer.trainerid}`}>{trainer.name}</Link>
          </li>
        ))}
      </ul>
    </div>
  );
}
