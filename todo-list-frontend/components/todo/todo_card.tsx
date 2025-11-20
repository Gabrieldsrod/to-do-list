import './todo_card.css';

interface TodoCardProps {
    id: number;
    title: string;
    description: string;
    status: string;
    priority: string;
}
export function Card({ title, description, priority, status }: TodoCardProps) {
  const priorityClass = (() => {
    switch (priority) {
      case 'High':
        return 'priority-high';
      case 'Medium':
        return 'priority-medium';
      case 'Low':
      default:
        return 'priority-low';
    }
  })();

  return (
    <div className={`todo-card ${priorityClass}`}>
      <h2>{title}</h2>
      <p>{description}</p>

      <div className="status-row">
        <span className="status-label">Status:</span>
        <span className="status-text">{status}</span>
      </div>
      
      <div className="buttons">
        <button className="delete">Delete</button>
        <button className="finish">Mark as Finished</button>
      </div>
    </div>
  );
}