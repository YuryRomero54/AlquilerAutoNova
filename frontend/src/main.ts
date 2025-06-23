import { bootstrapApplication } from '@angular/platform-browser';
import { AppComponent } from './app/app.component';
import { provideRouter } from '@angular/router';
import { provideHttpClient } from '@angular/common/http'; // ✅ Importar HttpClient
import { routes } from './app/app.routes'; // ✅ Importar rutas

bootstrapApplication(AppComponent, {
  providers: [
    provideRouter(routes),       // ✅ Habilita rutas
    provideHttpClient()          // ✅ Habilita HttpClient para servicios REST
  ]
}).catch(err => console.error(err));
