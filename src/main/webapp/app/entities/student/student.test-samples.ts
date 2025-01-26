import { IStudent, NewStudent } from './student.model';

export const sampleWithRequiredData: IStudent = {
  id: 15380,
};

export const sampleWithPartialData: IStudent = {
  id: 28775,
  name: 'fly gah',
};

export const sampleWithFullData: IStudent = {
  id: 6617,
  name: 'pleasant plain petty',
};

export const sampleWithNewData: NewStudent = {
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
