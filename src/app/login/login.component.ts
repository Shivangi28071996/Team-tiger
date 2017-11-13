import { Component, OnInit } from '@angular/core';
import {AppService} from '../app.services'
import {Signup} from '../signup/signup'
import {Login} from './login'
import {Router} from '@angular/router';
import 'rxjs/add/operator/switchMap';
import {ActivatedRoute,ParamMap} from '@angular/router';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  providers:[AppService]
})
export class LoginComponent implements OnInit {
l1:Signup[]=[];
a:boolean=false;
b:boolean;
// reg1:any={};
// reg2:any={};
  constructor(private service:AppService,private router:Router,private route:ActivatedRoute) { }

  ngOnInit() {
    this.service.getdetail()
    .subscribe(l1=>{
      this.l1=l1
    });
    // this.route.paramMap
    // .switchMap((params: ParamMap) => this.service.get(+params.get('id')))
    // .subscribe(id => {this.reg1 = id});
  }
  login(l:Login){
     console.log(l.email);
     console.log(l.password);
    let l2=new Login(l.email,l.password);

      for(var i=0;i<this.l1.length;i++){

      if(this.l1[i].email==l.email){
        if(!this.service.loggedin(l2,this.l1)){
         this.a=false;  
          this.b=true;   
        } 
      }
      else{
        this.b=false
        this.a=true;
        
      }
  }
    }
  }

    

