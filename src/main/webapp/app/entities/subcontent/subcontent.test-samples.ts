import { ISubcontent, NewSubcontent } from './subcontent.model';

export const sampleWithRequiredData: ISubcontent = {
  id: 26134,
};

export const sampleWithPartialData: ISubcontent = {
  id: 32723,
  description: 'snow writhing duh',
};

export const sampleWithFullData: ISubcontent = {
  id: 20272,
  name: 'often with',
  description: 'yet wallop woot',
};

export const sampleWithNewData: NewSubcontent = {
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
