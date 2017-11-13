import { Component, OnInit } from '@angular/core';
import {SubmitDetails} from '../submitproperty/submit'
import {AppService} from '../app.services';
import {Signup} from '../signup/signup';
import 'rxjs/add/operator/switchMap';
import {ActivatedRoute,ParamMap} from '@angular/router';
@Component({
  selector: 'app-myproperty',
  templateUrl: './myproperty.component.html',
  styleUrls: ['./myproperty.component.css'],
  providers:[AppService]
})
export class MypropertyComponent implements OnInit {
   iproperty:SubmitDetails[]=[];
   iproperty1:SubmitDetails;
   iproperty2:SubmitDetails;
  //  property:SubmitDetails[]=[]
  //  j=0;
  sign:Signup;
   a:any;
  // responseStatus:Object=[];
  submitted:boolean;
  deleted:boolean;
  
     constructor(private service:AppService,private route: ActivatedRoute) { }
  
   ngOnInit():void{
   this.service.getdetail1()
   .subscribe(l1=>{
      this.iproperty=l1
    });
    // this.show();
    this.route.paramMap
    .switchMap((params: ParamMap) => this.service.get(+params.get('id')))
    .subscribe(id => {this.sign = id});
     }
  
// show(){
//   for(var i=0;i<this.iproperty.length;i++){
//   if(this.iproperty[i].stat==1){
//     this.property[this.j]=this.iproperty[i];
//     this.j++;
//   }
// }
// }
  
  delete1(y){
  console.log(y);
  for(var i=0;i<this.iproperty.length;i++)
    {
      if(this.iproperty[i].propId==y)
      {
        this.iproperty2=this.iproperty[i];
      }
    }
  }
  
  delete(z){
    console.log(z);
  // this.service.deletedetail1(z).subscribe(t=>{console.log(t);this.ngOnInit()});
  for(var i=0;i<this.iproperty.length;i++)
  {
    if(this.iproperty[i].propId==z)
    {
      //
    }
  }
  }
  
  edit1(x:number){
    //console.log(this.iproperty);
  for(var i=0;i<this.iproperty.length;i++)
    {
      if(this.iproperty[i].propId===x)
      {
        this.iproperty1=this.iproperty[i];
        // console.log(this.iproperty[i].propId.);
      }
    }
  this.a=1;
  }

  edit(y,x){
    console.log(x);
    console.log(y.bathroom);
    console.log(y.name);
    console.log(y.email);
    console.log(y.propStatus);
    console.log(y.type);
    console.log(y.title);
  let z= new SubmitDetails(y.name,y.email,y.propStatus,y.type,y.rooms,y.bathroom,
        y.title,y.price,y.area,y.address,y.postalcode,y.phone,y.info,y.parking,y.ac,y.sit,y.pool,y.window,y.alarm,y.heating,y.gym,y.laundry,x);
  //console.log(this.sign.id);
  console.log(z);
  this.service.update1(z,x).subscribe(t => {console.log(t);this.ngOnInit()});
 // console.log(z);
  this.deleted=false;
  this.submitted=true; 
}
  
  
}
