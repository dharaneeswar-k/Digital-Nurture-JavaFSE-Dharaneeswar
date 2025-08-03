import { useParams } from 'react-router-dom';
import TrainerMock from './TrainerMock';

export default function TrainerDetail() {
  const { id } = useParams();
  const trainer = TrainerMock.find(t => t.trainerid === id);

  return trainer ? (
    <div style={{ padding: '15px' }}>
      <h2>Trainers Details</h2>
      <h3>{trainer.name} ({trainer.technology})</h3>
      <p>{trainer.email}</p>
      <p>{trainer.phone}</p>
      <ul>
        {trainer.skills.map((skill, index) => (
          <li key={index}>{skill}</li>
        ))}
      </ul>
    </div>
  ) : (
    <p>Trainer not found.</p>
  );
}
