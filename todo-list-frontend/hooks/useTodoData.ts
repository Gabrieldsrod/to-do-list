import { useQuery } from "@tanstack/react-query";
import type { TodoData } from './../interface/TodoData';
import axios from "axios";

const API_URL = "http://localhost:8080";

export const fetchData = async (): Promise<TodoData[]> => {
    const response = await axios.get<TodoData[]>(`${API_URL}/todos`);
    return response.data;
}

export function useTodoData() {
    const query = useQuery<TodoData[]>({
        queryKey: ['todoData'],
        queryFn: fetchData,
        retry: 2
    });

    return query;
}