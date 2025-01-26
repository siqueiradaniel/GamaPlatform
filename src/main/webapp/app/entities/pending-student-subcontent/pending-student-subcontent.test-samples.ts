import { IPendingStudentSubcontent, NewPendingStudentSubcontent } from './pending-student-subcontent.model';

export const sampleWithRequiredData: IPendingStudentSubcontent = {
  id: 18432,
};

export const sampleWithPartialData: IPendingStudentSubcontent = {
  id: 26346,
  currentStatus: 'consistency er',
};

export const sampleWithFullData: IPendingStudentSubcontent = {
  id: 13301,
  currentStatus: 'probe enroll louse',
};

export const sampleWithNewData: NewPendingStudentSubcontent = {
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
