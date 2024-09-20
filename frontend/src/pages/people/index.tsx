import {useEffect, useState} from "react";
import Link from "next/link";

export interface Person {
    id: number;
    name: string;
    age: number;
    height: number;
}

export default function Page() {
    const [data, setData] = useState<Person[] | null>(null);
    const [isLoading, setLoading] = useState(true);

    useEffect(() => {
        fetch(`${process.env.NEXT_PUBLIC_BACKEND_BASE_URL!}/api/people`)
            .then((res) => res.json())
            .then((data: Person[]) => { // Specify the type here
                setData(data);
                setLoading(false);
            })
            .catch((error) => {
                console.error("Error fetching data:", error);
                setLoading(false);
            });
    }, []);

    if (isLoading) return <p>Loading...</p>;
    if (!data) return <p>No profile data</p>;

    return (
        <div>
            <h2>People List</h2>
            <ul>
                {data.map((person, index) => (
                    <li key={index}>
                        <Link href={`/people/${person.id}`}>
                            {person.name}, {person.age} years old
                        </Link>
                    </li>
                ))}
            </ul>
        </div>
    );
}