import { useQuery } from "@tanstack/react-query";
import type { TodoData } from './../interface/TodoData';
import axios, { type AxiosPromise } from "axios";

const API_URL = "http://localhost:8080";

export const fetchData = async (): AxiosPromise<TodoData[]> => {
    const response = await axios.get(API_URL + '/todos');
    return response;
}

export function useTodoData() {
    const query = useQuery({
        queryFn: fetchData,
        queryKey: ['todoData'],
        retry: 2
    });

    return {
        ...query,
        data: query.data?.data
    };
}