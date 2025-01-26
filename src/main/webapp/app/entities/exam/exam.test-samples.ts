import { IExam, NewExam } from './exam.model';

export const sampleWithRequiredData: IExam = {
  id: 19529,
};

export const sampleWithPartialData: IExam = {
  id: 20431,
  name: 'blah',
  description: 'ocelot as',
};

export const sampleWithFullData: IExam = {
  id: 21245,
  name: 'critical upright',
  description: 'always',
};

export const sampleWithNewData: NewExam = {
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
