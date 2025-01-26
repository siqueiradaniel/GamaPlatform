import { ISubcontent } from 'app/entities/subcontent/subcontent.model';
import { IStudent } from 'app/entities/student/student.model';

export interface IPendingStudentSubcontent {
  id: number;
  currentStatus?: string | null;
  subcontent?: Pick<ISubcontent, 'id'> | null;
  student?: Pick<IStudent, 'id'> | null;
}

export type NewPendingStudentSubcontent = Omit<IPendingStudentSubcontent, 'id'> & { id: null };
