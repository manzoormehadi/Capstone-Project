import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DashboardComponent } from './dashboard/dashboard.component';
import { FavouriteComponent } from './favourite/favourite.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';
import { ReviewPageComponent } from './review-page/review-page.component';
import { ReviewComponent } from './review/review.component';

const routes: Routes = [
  {
    path: 'Registration', component: RegistrationComponent
  },
  {
    path: 'Login', component: LoginComponent
  },
  {
    path: '', component: HomeComponent
  },
  {
    path: 'Dashboard', component: DashboardComponent

  },
  {
    path: 'Review', component: ReviewComponent
  },

  {
    path: 'Favourite', component: FavouriteComponent
  },

  {
    path: 'Home', component: HomeComponent
  },

  {
    path: 'ReviewPage', component: ReviewPageComponent
  }
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
