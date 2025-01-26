import { Routes } from '@angular/router';

const routes: Routes = [
  {
    path: 'authority',
    data: { pageTitle: 'gamaPlatformApp.adminAuthority.home.title' },
    loadChildren: () => import('./admin/authority/authority.routes'),
  },
  {
    path: 'content',
    data: { pageTitle: 'gamaPlatformApp.content.home.title' },
    loadChildren: () => import('./content/content.routes'),
  },
  {
    path: 'dependency',
    data: { pageTitle: 'gamaPlatformApp.dependency.home.title' },
    loadChildren: () => import('./dependency/dependency.routes'),
  },
  {
    path: 'exam',
    data: { pageTitle: 'gamaPlatformApp.exam.home.title' },
    loadChildren: () => import('./exam/exam.routes'),
  },
  {
    path: 'learning-path',
    data: { pageTitle: 'gamaPlatformApp.learningPath.home.title' },
    loadChildren: () => import('./learning-path/learning-path.routes'),
  },
  {
    path: 'pending-student-subcontent',
    data: { pageTitle: 'gamaPlatformApp.pendingStudentSubcontent.home.title' },
    loadChildren: () => import('./pending-student-subcontent/pending-student-subcontent.routes'),
  },
  {
    path: 'student',
    data: { pageTitle: 'gamaPlatformApp.student.home.title' },
    loadChildren: () => import('./student/student.routes'),
  },
  {
    path: 'subcontent',
    data: { pageTitle: 'gamaPlatformApp.subcontent.home.title' },
    loadChildren: () => import('./subcontent/subcontent.routes'),
  },
  /* jhipster-needle-add-entity-route - JHipster will add entity modules routes here */
];

export default routes;
