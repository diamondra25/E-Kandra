import { useAuth } from '../Contexts/AuthContext';
import { useEffect } from 'react';

function Home() {
  const { user, logout } = useAuth();

  useEffect(() => {
    console.log("User dans Home:", user);
  }, [user]);

  if (!user) {
    return <p>Chargement des données utilisateur...</p>;
  }

  return (
    <>
      <h1>Bienvenue {user.prenom}</h1>
      <p>Email: {user.email}</p>
      <button onClick={logout}>Déconnexion</button>
    </>
  );
}

export default Home;
