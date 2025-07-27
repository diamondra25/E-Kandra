import axios from "axios";
import type { User } from "../interface/gobal.interface";

export const signin = async (url: string, user : User, file1 : any, file2 : any, file3:any) => {
  const formData = new FormData();
  formData.append("user", JSON.stringify(user));
  formData.append("file", file1);
  formData.append("file2", file2);
  formData.append("file3", file3);

  try {
    const response = await axios.post(`${url}/auth/register` ,formData, {
      headers: {
        "Content-Type": "multipart/form-data",
      },
    });
    localStorage.setItem('token', response.data.token);
    return response.data;
  } catch (err) {
    const error = err as Error;
    throw error.message || "Erreur d'inscription";
  }
};


export const loginF = async (url:string,email : string, password : string) => {
  try {
    const response = await axios.post(`${url}/auth/login`, {
      email,
      password,
    });
    return response;
  } catch (err) {
    const error = err as Error;
    throw error.message|| "Erreur de connexion";
  }
};
