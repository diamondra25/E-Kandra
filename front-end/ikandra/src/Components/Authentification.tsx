import { useState } from "react";
import type { User } from "../interface/gobal.interface";
import { loginF, signin } from "../Function/Auth.function";
import { useAuth } from '../Contexts/AuthContext';

function Authentification({ api_url , log}: { api_url: string , log: boolean }){
    const [user, setUser]= useState<User>({
        id: 0,
        nom_user: '',
        prenom: '',
        photo_url: '',
        cin_recto_url: '',
        cin_verso_url: '',
        pseudo: '',
        email: '',
        role: 'FREELANCER',
        password: '',
        bio: '',
        phone: '',
        solde: 0,
        is_active: false,
        
        offers: [],
        notifications: [],
        senderMessages: [],
        receiverMessages: [],
        senderTransactions: [],
        receiverTransactions: [],
        orders: [],
    });
    const [file, setFile]=useState<File|null>();
    const [file2, setFile2]=useState<File|null>();
    const [file3, setFile3]=useState<File|null>();
    const [signin_email, setsignin_email]=useState("");
    const [signin_pwd, setSignin_pwd]=useState("");
    const { login } = useAuth();

    const handleChange = (key: keyof User, value: any) => {
        setUser((prev) => ({ ...prev, [key]: value }));
    };

    const register =async(e: React.FormEvent)=>{
        e.preventDefault();
        const response = await signin(api_url, user, file, file2, file3);
        if (!user) {
            alert("Veuillez remplir le formulaire.");
            return;
        }
    }

    const connect = async(e:React.FormEvent)=>{
        e.preventDefault();
        const response = await loginF(api_url, signin_email, signin_pwd);
        login(response.data.user, response.data.token);

    }

    const login_form=()=>{
        return(
            <>
                <form onSubmit={register}>
                    <div>
                        <div>
                            <label>Nom</label>
                            <input type="text" value={user?.nom_user} onChange={(e) => handleChange('nom_user', e.target.value)}/>
                        </div>

                        <div>
                            <label>Prénom</label>
                            <input type="text" value={user?.prenom} onChange={(e)=>handleChange('prenom', e.target.value)}/>
                        </div>

                        <div>
                            <label>Photo d'identité</label>
                            <input type="file"   
                            onChange={(e) => {setFile(e.target.files ? e.target.files[0] : null)} }/>
                        </div>

                        <div>
                            <label>Photo CIN recto</label>
                            <input type="file" 
                            onChange={(e) => {setFile2(e.target.files ? e.target.files[0] : null)} }/>
                        </div>

                        <div>
                            <label>Photo CIN verso</label>
                            <input type="file" 
                            onChange={(e) => {setFile3(e.target.files ? e.target.files[0] : null)} }/>

                        </div>

                        <div>
                            <label>Pseudo</label>
                            <input type="text" value={user?.pseudo} onChange={(e)=>handleChange('pseudo', e.target.value)}/>
                        </div>

                        <div>
                            <label>E-mail</label>
                            <input type="email" value={user?.email} onChange={(e)=>handleChange('email', e.target.value)}/>
                        </div>

                        <div>
                            <label>Votre Bio</label>
                            <textarea value={user?.bio} onChange={(e)=>handleChange('bio', e.target.value)}/>
                        </div>

                        <div>
                            <label>Numéro de téléphone</label>
                            <input type="tel" value={user?.phone} onChange={(e)=>handleChange('phone', e.target.value)}/>
                        </div>

                        <div>
                            <label>Mot de passe</label>
                            <input type="password" value={user?.password} onChange={(e)=>handleChange('password', e.target.value)}/>
                        </div>

                        <div>
                            <label>Confirmer votre mot de passe</label>
                            <input type="password" />
                        </div>

                    </div>
                    <div>
                        <button type="submit" >Envoyer</button>
                        <button type="button">Annuler</button>
                    </div>
                </form>
            </>
        );
    }
    const signin_form=()=>{
        return(
            <>
                <form onSubmit={connect}>
                    <div>
                        <div>
                            <label>E-mail</label>
                            <input type="text" value={signin_email} onChange={(e)=>setsignin_email(e.target.value)} />
                        </div>

                        <div>
                            <label>Mot de passe</label>
                            <input type="password" value={signin_pwd} onChange={(e)=>setSignin_pwd(e.target.value)} />
                        </div>
                    </div>
                    <div>
                        <button type="submit">Se connecter</button>
                        <button type="button">Annuler</button>
                    </div>
                </form>
            </>
        )
    }
    return(
        log ? login_form() : signin_form()
    )
}

    
export default Authentification;