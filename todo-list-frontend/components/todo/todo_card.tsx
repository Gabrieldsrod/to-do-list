import './todo_card.css';

interface TodoCardProps {
    title: string;
    description: string;
    todoStatus: string;
    todoPriority: number;
}
export function Card({title, description }: TodoCardProps) {
  return (
    <div className="card">
      <h2>{title}</h2>
      <p>{description}</p>
    </div>
  );
}