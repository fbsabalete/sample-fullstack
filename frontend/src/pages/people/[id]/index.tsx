import {useEffect, useState} from "react";
import {useRouter} from "next/router";
import {Person} from "@/pages/people";


export default function PersonDetails() {
    const [data, setData] = useState<Person|null>();

    const router = useRouter();
    useEffect(() => {
        fetch(`${process.env.NEXT_PUBLIC_BACKEND_BASE_URL!}/api/people/${router.query.id}`)
            .then((res) => res.json())
            .then((data: Person) => { // Specify the type here
                setData(data);
            })
            .catch((error) => {
                console.error("Error fetching data:", error);
            });
    }, [])
    if (!data) return <p>No profile data</p>;

    return (
        <div>
            <h3>Person Details</h3>
            <p><strong>Name:</strong> {data.name}</p>
            <p><strong>Age:</strong> {data.age} years old</p>
            <p><strong>Height:</strong> {data.height} years old</p>
        </div>
    );
}