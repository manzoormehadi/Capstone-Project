import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { FavoritesComponent } from './favorites/favorites.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { LoginComponent } from './login/login.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MaterialModule } from './material/material.module';
import { HttpModule } from '@angular/http';
import { FormsModule,ReactiveFormsModule, FormArray } from '@angular/forms';
import { UserService } from './services/user.service';
import { SignupComponent } from './signup/signup.component';
import { TrackService } from './services/track.service';
import { FormBuilder} from '@angular/forms';
import { RecommendComponent } from './recommend/recommend.component';
import {MatSnackBarModule} from '@angular/material/snack-bar';

@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    FavoritesComponent,
    PageNotFoundComponent,
    LoginComponent,
    SignupComponent,
    RecommendComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MaterialModule,
    HttpModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    MatSnackBarModule
  ],
  providers: [UserService,TrackService],
  bootstrap: [AppComponent]
})
export class AppModule { }
