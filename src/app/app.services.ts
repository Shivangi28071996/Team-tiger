import {Injectable} from '@angular/core';
import { Http , Response,Headers,RequestOptions } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';//for mapping
import 'rxjs/add/operator/do';
import 'rxjs/add/operator/catch';
import {Router} from '@angular/router';
import {Signup} from './signup/signup';
import {Login} from './login/login'
import{SubmitDetails} from './submitproperty/submit'
@Injectable()
export class AppService{
private url="http://localhost:8080/addpersonaldetail";
//private url1="http://localhost:8080/addpropertydetail";
private retrieveurl="http://localhost:8080/getpersonaldetail";
private retrieveurl1="http://localhost:8080/getpropertydetail";
constructor(private http:Http,private router:Router){}

getdetail():Observable<Signup[]>{
    return this.http.get(this.retrieveurl)
      .map((response:Response) => <Signup[]> response.json())
      .do(data => console.log(JSON.stringify(data)))
      .catch(this.handleError);
}

getdetail1():Observable<SubmitDetails[]>{
    return this.http.get(this.retrieveurl1)
      .map((response:Response) => <SubmitDetails[]> response.json())
      .do(data => console.log(JSON.stringify(data)))
      .catch(this.handleError);
}

get(id:number):Observable<Signup>{
    return this.getdetail().map(user=>user.find(u=>u.id===id))
}

post(sign:Signup):Observable<Signup>{
    let headers=new Headers({'Content-Type':'application/json'});
    let opts=new RequestOptions({headers:headers});
    return this.http.post(this.url,JSON.stringify(sign),opts)
    .map(() => null)
    .catch(this.handleError);
}
post1(sign:SubmitDetails,id:number):Observable<SubmitDetails>{
    let headers=new Headers({'Content-Type':'application/json'});
    let opts=new RequestOptions({headers:headers});
    return this.http.post("http://localhost:8080/addpropertydetail/"+id,JSON.stringify(sign),opts)
    .map(() => null)
    .catch(this.handleError);
}

loggedin(l:Login,s1:Signup[]){
    var authuser=s1.find(user1=>user1.email===l.email);
    if(authuser && authuser.password===l.password){
        localStorage.setItem("user","authuser");
        if(authuser.stat=="seller"){
            this.router.navigate(['/seller',authuser.id]);
        }
        else if(authuser.stat=="buyer"){
           this.router.navigate(['/buyer',authuser.id]); 
        }
        return true;
    }
    return false;
}

logout(){
    localStorage.removeItem("user");
    this.router.navigate(['/Login']);
}

checkcredentials(){
   

    if(localStorage.getItem("user")==null){
        this.router.navigate(['/Login']);
        console.log("kol...");
    }
    
    else{
        console.log("...........................");
    }
}

pricingnavigate(){
    if(localStorage.getItem("user")==null){
        this.router.navigate(['/Login']);
    }
    else{
        this.router.navigate(['/payment'])
    }
}

update(property:Signup):Observable<Signup>{
    let headers=new Headers({'Content-Type':'application/json'});
    let opts=new RequestOptions({headers:headers});
    return this.http.put("http://localhost:8080/updatedetail/"+property.id.toString(),JSON.stringify(property),opts)
    //.map(this.extractData)
    .catch(this.handleError);
   }
   update1(property:SubmitDetails,id:number):Observable<Response>{
    let headers=new Headers({'Content-Type':'application/json'});
    let opts=new RequestOptions({headers:headers});
    return this.http.put("http://localhost:8080/updatepropertydetail/"+id.toString(),JSON.stringify(property),opts)
    .map((res:Response) => res)
    .catch(this.handleError);
   }

   deletedetail(prop:number){
       return this.http.delete("http://localhost:8080/deletedetail/"+prop.toString())
            .map(() => null)
            .catch(this.handleError);
   }
//    deletedetail1(prop:number){
//        return this.http.delete("http://localhost:8080/deletepropertydetail/"+prop.toString())
//             .map(() => null)
//             .catch(this.handleError);
//    }
private handleError(error:Response){
      console.error(error);
      return Observable.throw(error.json().error());
      
   }
}