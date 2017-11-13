import { Component, OnInit } from '@angular/core';
import {Signup} from './signup';
import {AppService} from '../app.services'
import {Router} from '@angular/router';
@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css'],
  providers:[AppService]
})
export class SignupComponent implements OnInit {
  flag:boolean=false;
  message:string;
  i:number;
  valid:boolean;
  l1:Signup[]=[];
  a:boolean;
  b:boolean;
  constructor(private service:AppService,private router:Router) { }

  ngOnInit() {
    this.service.getdetail()
    .subscribe(l1=>{
      this.l1=l1
    });
  }

  // uservalid(username:any){
 
   
  //   for(this.i=0;this.i<this.l1.length;this.i++){
  //     if(this.l1[this.i].username==username){
  //       console.log(this.l1[this.i].username);
  //       console.log(username);
        
  //       alert("username already present");
  //     }
  //     else{
  //       alert("check ");
  //     }
  //   }
  // }

  signup(f:Signup, y:String,z:String){
    // console.log(f.phone);
    // console.log(f.email);
    // console.log(f.fullname);
    // console.log(f.password);
    // console.log(f.username);
    // console.log(y);
    console.log(f);
    console.log(y);
    console.log(z)
    
    for(this.i=0;this.i<=this.l1.length;this.i++){
      console.log("for loop");
          if(this.l1[this.i].username!=f.username){
            console.log("username not found");
                 if(f.password===z)
                  { console.log("password match") 
                    this.a=false;
                    this.b=false;
                    let x=new Signup(f.fullname,f.email,f.password,y,f.phone,f.username);
                      this.service.post(x).subscribe(t => {console.log(t),this.ngOnInit});
                      this.router.navigate(['/Login']);
                  }
                   else
                      { this.a=true;
                    }
            }
            else{
              this.b=true;
            }
      }

}

//matchpass:any;

// myfun(pass:any)
// {
//   this.matchpass = pass;
// }
// match(confirmpassword)

  
//   if(this.matchpass.value!=confirmpassword.value)
//   {   this.flag=true;
//     this.message="password mismatch...";
//     this.valid=false;
//   }
//   else
//   {this.flag=false;
//     this.valid=true;
//   }
// }

}

