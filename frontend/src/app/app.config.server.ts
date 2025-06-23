import { ApplicationConfig } from '@angular/core';
import { provideRouter } from '@angular/router';
import { routes } from './app.routes';
import { provideServerRendering } from '@angular/platform-server';
import { provideHttpClient } from '@angular/common/http'; // ✅ AÑADE ESTO

export const config: ApplicationConfig = {
  providers: [
    provideRouter(routes),
    provideServerRendering(),
    provideHttpClient() // ✅ AGREGA ESTO AQUÍ
  ]
};
