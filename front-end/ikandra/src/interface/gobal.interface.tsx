export interface Category{
    id:number;
    name:string;
    offers?: Offer[];
}

export interface Message{
    id : number;
    content:string;
    send_at?: string;
    
    sender : User;
    receiver:User;
}

export interface Notification{
    id:number;
    content: string;
    is_read:Boolean;
    created_at?:string;

    user:User;
}


export interface Offer_image{
    id: number;
    image_url?:string;
    
    offer: Offer;
}

export interface Offer{
    id:number;
    title:string;
    designation:string;
    base_price:number;
    delivery_time_days:number;
    created_at?:string;
    is_active:Boolean;

    freelancer:User;
    catergory:Category;
    images?:Offer_image[];
    orders: Order;
}

export interface Order{
    client : User;
    offer: Offer;
    status : 'Pending' | 'InProgress' | 'Delivered'| 'Completed'| 'Cancelled'| 'Expired';
    price :number;
    created_at?:string;
    delivered_at?:string;
    completed_at?:string;
   
    reviews? :Review[];
    payment?: Payement [];
}

export interface Payement{
    id: number;
    payment_method: string;
    amount: number;
    status : 'Pending' | 'InProgress' | 'Delivered'| 'Completed'| 'Cancelled'| 'Expired';
    paid_at: string;

    ordered : Order;
}

export interface Review{
    id:number;
    rating: number;
    
    order:Order;
}

export interface Transaction{
    id: number;
    amount: number;
    send_at:string;
    status : 'Pending' | 'InProgress' | 'Delivered'| 'Completed'| 'Cancelled'| 'Expired';

    sender_account:User;
    receiver_account:User;
}

export interface User {
  id: number;
  nom_user: string;
  prenom?: string;
  photo_url?: string;
  cin_recto_url?: string;
  cin_verso_url?: string;
  pseudo: string;
  email: string;
  role: 'FREELANCER' | 'CLIENT' | 'ADMIN'; 
  password: string;
  bio?: string;
  phone: string;
  solde?: number;
  is_active: boolean;

  offers?: Offer[];
  notifications?: Notification[];
  senderMessages?: Message[];
  receiverMessages?: Message[];
  senderTransactions?: Transaction[];
  receiverTransactions?: Transaction[];
  orders?: Order[];
}
