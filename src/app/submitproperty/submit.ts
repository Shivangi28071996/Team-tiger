export class SubmitDetails
{   propId:number;
    title:String;
    propStatus:String;
    type:String;
    price:number;
    area:number;
    rooms:number;
    bathroom:number;
    address:String;
    postalcode:number;
    info:String;
    parking:boolean=false;
    ac:boolean=false;
    sit:boolean=false;
    pool:boolean=false;
    window:boolean=false;
    heating:boolean=false;
    alarm:boolean=false;
    gym:boolean=false;
    laundry:boolean=false;
    name:String;
    email:String;
    phone:number;
    //stat:number;
   //userid:Signup;
constructor(name,email,propStatus,type,rooms,bathroom,
        title,price,area,address,postalcode,phone,info,parking,ac,sit,pool,window,alarm,heating,gym,laundry,propId?:number)
        {
            this.name=name;
            this.email=email;
            this.propStatus=propStatus;
            this.type=type;
            this.rooms=rooms;
            this.bathroom=bathroom;
            this.title=title;
            this.price=price;
            this.area=area;
            this.address=address;
            this.postalcode=postalcode;
            this.phone=phone;
            this.info=info;
            this.parking=parking;
            this.ac=ac;
            this.sit=sit;
            this.pool=pool;
            this.window=window;
            this.alarm=alarm;
            this.heating=heating;
            this.gym=gym;
            this.laundry=laundry;
            this.propId=propId;
            //this.stat=1;
     //       this.userid=userid;
}
}