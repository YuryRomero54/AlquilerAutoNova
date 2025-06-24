import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule,FormsModule, FormGroup, FormBuilder, Validators, FormControl } from '@angular/forms';
import{NzMessageService} from "ng-zorro-antd/message"

// Ng Zorro
import { NzFormModule } from 'ng-zorro-antd/form';
import { NzInputModule } from 'ng-zorro-antd/input';
import { NzButtonModule } from 'ng-zorro-antd/button';
import { NzSpinModule } from 'ng-zorro-antd/spin';
import { Route, Router, RouterModule } from '@angular/router'; 
import { AuthService } from '../../services/auth/auth.service';

@Component({
  selector: 'app-signup',
  standalone: true,
  imports: [
    CommonModule,
    ReactiveFormsModule,
    NzFormModule,
    NzInputModule,
    NzButtonModule,
      NzSpinModule, 
        FormsModule,
         RouterModule,
  ],
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']  
})
export class SignupComponent {
  isSpinning: boolean= false;
  signupForm!: FormGroup;

  constructor(private fb: FormBuilder, private authService:AuthService,
    private message:NzMessageService, private router: Router
  ){}

  ngOnInit(){
  this.signupForm = this.fb.group({
  nombreCompleto: [null, [Validators.required]],
  apellidos: [null, [Validators.required]],
  categoriaLicencia: [null, [Validators.required]],
  telefono: [null, [Validators.required]],
  fechaExpedicionLicencia: [null, [Validators.required]],
  vigencia: [null, [Validators.required]],
  correoUsuario: [null, [Validators.required, Validators.email]],
  password: [null, [Validators.required]],
 checkPassword: [null, [Validators.required, this.confirmationValide]]

});
  }

  confirmationValide=(control:FormControl): {[s:string]: boolean}=> {
    if (!control.value){
      return{required: true};
    }
    else if (control.value !== this.signupForm.controls['password'].value){
      return {confirm: true, error : true};
    }
    return{}
    };
  
register(){
  console.log(this.signupForm.value);
  const formData = { ...this.signupForm.value };
  delete formData.checkPassword; 
  this.authService.register(formData).subscribe((res) => {
    console.log(res);
   if (res.message === "Registro Exitoso") {
  this.message.success("Signup successful", { nzDuration: 1000 });
  this.router.navigateByUrl("/login");
} else {
  this.message.error("Algo salió mal", { nzDuration: 1000 });
}
  });
}}
